import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'name-basics',
        loadChildren: () => import('./name-basics/name-basics.module').then(m => m.NetzonNameBasicsModule),
      },
      {
        path: 'title-basics',
        loadChildren: () => import('./title-basics/title-basics.module').then(m => m.NetzonTitleBasicsModule),
      },
      {
        path: 'title-ratings',
        loadChildren: () => import('./title-ratings/title-ratings.module').then(m => m.NetzonTitleRatingsModule),
      },
      {
        path: 'title-crew',
        loadChildren: () => import('./title-crew/title-crew.module').then(m => m.NetzonTitleCrewModule),
      }
    ]),
  ],
})
export class NetzonEntityModule {}
