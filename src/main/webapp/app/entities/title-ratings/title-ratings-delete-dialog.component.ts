import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITitleRatings } from 'app/shared/model/title-ratings.model';
import { TitleRatingsService } from './title-ratings.service';

@Component({
  templateUrl: './title-ratings-delete-dialog.component.html',
})
export class TitleRatingsDeleteDialogComponent {
  titleRatings?: ITitleRatings;

  constructor(
    protected titleRatingsService: TitleRatingsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.titleRatingsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('titleRatingsListModification');
      this.activeModal.close();
    });
  }
}
