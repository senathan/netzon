import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { NetzonSharedModule } from 'app/shared/shared.module';
import { TitleCrewComponent } from './title-crew.component';
import { TitleCrewDetailComponent } from './title-crew-detail.component';
import { TitleCrewUpdateComponent } from './title-crew-update.component';
import { TitleCrewDeleteDialogComponent } from './title-crew-delete-dialog.component';
import { titleCrewRoute } from './title-crew.route';

@NgModule({
  imports: [NetzonSharedModule, RouterModule.forChild(titleCrewRoute)],
  declarations: [TitleCrewComponent, TitleCrewDetailComponent, TitleCrewUpdateComponent, TitleCrewDeleteDialogComponent],
  entryComponents: [TitleCrewDeleteDialogComponent],
})
export class NetzonTitleCrewModule {}
