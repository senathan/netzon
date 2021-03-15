import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ITitleRatings } from 'app/shared/model/title-ratings.model';
import { TitleRatingsService } from './title-ratings.service';
import { TitleRatingsDeleteDialogComponent } from './title-ratings-delete-dialog.component';

@Component({
  selector: 'jhi-title-ratings',
  templateUrl: './title-ratings.component.html',
})
export class TitleRatingsComponent implements OnInit, OnDestroy {
  titleRatings?: ITitleRatings[];
  eventSubscriber?: Subscription;

  constructor(
    protected titleRatingsService: TitleRatingsService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.titleRatingsService.query().subscribe((res: HttpResponse<ITitleRatings[]>) => (this.titleRatings = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInTitleRatings();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ITitleRatings): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInTitleRatings(): void {
    this.eventSubscriber = this.eventManager.subscribe('titleRatingsListModification', () => this.loadAll());
  }

  delete(titleRatings: ITitleRatings): void {
    const modalRef = this.modalService.open(TitleRatingsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.titleRatings = titleRatings;
  }
}
