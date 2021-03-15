import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { INameBasics } from 'app/shared/model/name-basics.model';
import { NameBasicsService } from './name-basics.service';
import { NameBasicsDeleteDialogComponent } from './name-basics-delete-dialog.component';

@Component({
  selector: 'jhi-name-basics',
  templateUrl: './name-basics.component.html',
})
export class NameBasicsComponent implements OnInit, OnDestroy {
  nameBasics?: INameBasics[];
  eventSubscriber?: Subscription;

  constructor(protected nameBasicsService: NameBasicsService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.nameBasicsService.query().subscribe((res: HttpResponse<INameBasics[]>) => (this.nameBasics = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInNameBasics();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: INameBasics): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInNameBasics(): void {
    this.eventSubscriber = this.eventManager.subscribe('nameBasicsListModification', () => this.loadAll());
  }

  delete(nameBasics: INameBasics): void {
    const modalRef = this.modalService.open(NameBasicsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.nameBasics = nameBasics;
  }
}
