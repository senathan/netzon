import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { NetzonSharedModule } from 'app/shared/shared.module';
import { TitleRatingsComponent } from './title-ratings.component';
import { TitleRatingsDetailComponent } from './title-ratings-detail.component';
import { TitleRatingsUpdateComponent } from './title-ratings-update.component';
import { TitleRatingsDeleteDialogComponent } from './title-ratings-delete-dialog.component';
import { titleRatingsRoute } from './title-ratings.route';

@NgModule({
  imports: [NetzonSharedModule, RouterModule.forChild(titleRatingsRoute)],
  declarations: [TitleRatingsComponent, TitleRatingsDetailComponent, TitleRatingsUpdateComponent, TitleRatingsDeleteDialogComponent],
  entryComponents: [TitleRatingsDeleteDialogComponent],
})
export class NetzonTitleRatingsModule {}
