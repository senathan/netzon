import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITitleCrew } from 'app/shared/model/title-crew.model';
import { TitleCrewService } from './title-crew.service';

@Component({
  templateUrl: './title-crew-delete-dialog.component.html',
})
export class TitleCrewDeleteDialogComponent {
  titleCrew?: ITitleCrew;

  constructor(protected titleCrewService: TitleCrewService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.titleCrewService.delete(id).subscribe(() => {
      this.eventManager.broadcast('titleCrewListModification');
      this.activeModal.close();
    });
  }
}
