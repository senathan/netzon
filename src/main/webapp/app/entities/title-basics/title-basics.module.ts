import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { NetzonSharedModule } from 'app/shared/shared.module';
import { TitleBasicsComponent } from './title-basics.component';
import { TitleBasicsDetailComponent } from './title-basics-detail.component';
import { TitleBasicsUpdateComponent } from './title-basics-update.component';
import { TitleBasicsDeleteDialogComponent } from './title-basics-delete-dialog.component';
import { titleBasicsRoute } from './title-basics.route';

@NgModule({
  imports: [NetzonSharedModule, RouterModule.forChild(titleBasicsRoute)],
  declarations: [TitleBasicsComponent, TitleBasicsDetailComponent, TitleBasicsUpdateComponent, TitleBasicsDeleteDialogComponent],
  entryComponents: [TitleBasicsDeleteDialogComponent],
})
export class NetzonTitleBasicsModule {}
