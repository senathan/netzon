import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { NetzonSharedModule } from 'app/shared/shared.module';
import { NameBasicsComponent } from './name-basics.component';
import { NameBasicsDetailComponent } from './name-basics-detail.component';
import { NameBasicsUpdateComponent } from './name-basics-update.component';
import { NameBasicsDeleteDialogComponent } from './name-basics-delete-dialog.component';
import { nameBasicsRoute } from './name-basics.route';

@NgModule({
  imports: [NetzonSharedModule, RouterModule.forChild(nameBasicsRoute)],
  declarations: [NameBasicsComponent, NameBasicsDetailComponent, NameBasicsUpdateComponent, NameBasicsDeleteDialogComponent],
  entryComponents: [NameBasicsDeleteDialogComponent],
})
export class NetzonNameBasicsModule {}
