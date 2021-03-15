import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ITitleCrew } from 'app/shared/model/title-crew.model';
import { TitleCrewService } from './title-crew.service';
import { TitleCrewDeleteDialogComponent } from './title-crew-delete-dialog.component';

@Component({
  selector: 'jhi-title-crew',
  templateUrl: './title-crew.component.html',
})
export class TitleCrewComponent implements OnInit, OnDestroy {
  titleCrews?: ITitleCrew[];
  eventSubscriber?: Subscription;

  constructor(protected titleCrewService: TitleCrewService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.titleCrewService.query().subscribe((res: HttpResponse<ITitleCrew[]>) => (this.titleCrews = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInTitleCrews();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ITitleCrew): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInTitleCrews(): void {
    this.eventSubscriber = this.eventManager.subscribe('titleCrewListModification', () => this.loadAll());
  }

  delete(titleCrew: ITitleCrew): void {
    const modalRef = this.modalService.open(TitleCrewDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.titleCrew = titleCrew;
  }
}
