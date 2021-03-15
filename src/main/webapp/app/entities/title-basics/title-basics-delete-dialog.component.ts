import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITitleBasics } from 'app/shared/model/title-basics.model';
import { TitleBasicsService } from './title-basics.service';

@Component({
  templateUrl: './title-basics-delete-dialog.component.html',
})
export class TitleBasicsDeleteDialogComponent {
  titleBasics?: ITitleBasics;

  constructor(
    protected titleBasicsService: TitleBasicsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.titleBasicsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('titleBasicsListModification');
      this.activeModal.close();
    });
  }
}
