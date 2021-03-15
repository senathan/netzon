import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { INameBasics } from 'app/shared/model/name-basics.model';
import { NameBasicsService } from './name-basics.service';

@Component({
  templateUrl: './name-basics-delete-dialog.component.html',
})
export class NameBasicsDeleteDialogComponent {
  nameBasics?: INameBasics;

  constructor(
    protected nameBasicsService: NameBasicsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.nameBasicsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('nameBasicsListModification');
      this.activeModal.close();
    });
  }
}
