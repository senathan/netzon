import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ITitleBasics } from 'app/shared/model/title-basics.model';
import { TitleBasicsService } from './title-basics.service';
import { TitleBasicsDeleteDialogComponent } from './title-basics-delete-dialog.component';

@Component({
  selector: 'jhi-title-basics',
  templateUrl: './title-basics.component.html',
})
export class TitleBasicsComponent implements OnInit, OnDestroy {
  titleBasics?: ITitleBasics[];
  eventSubscriber?: Subscription;

  constructor(
    protected titleBasicsService: TitleBasicsService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.titleBasicsService.query().subscribe((res: HttpResponse<ITitleBasics[]>) => (this.titleBasics = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInTitleBasics();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ITitleBasics): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInTitleBasics(): void {
    this.eventSubscriber = this.eventManager.subscribe('titleBasicsListModification', () => this.loadAll());
  }

  delete(titleBasics: ITitleBasics): void {
    const modalRef = this.modalService.open(TitleBasicsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.titleBasics = titleBasics;
  }
}
