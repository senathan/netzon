import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ITitleBasics, TitleBasics } from 'app/shared/model/title-basics.model';
import { TitleBasicsService } from './title-basics.service';
import { TitleBasicsComponent } from './title-basics.component';
import { TitleBasicsDetailComponent } from './title-basics-detail.component';
import { TitleBasicsUpdateComponent } from './title-basics-update.component';

@Injectable({ providedIn: 'root' })
export class TitleBasicsResolve implements Resolve<ITitleBasics> {
  constructor(private service: TitleBasicsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ITitleBasics> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((titleBasics: HttpResponse<TitleBasics>) => {
          if (titleBasics.body) {
            return of(titleBasics.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new TitleBasics());
  }
}

export const titleBasicsRoute: Routes = [
  {
    path: '',
    component: TitleBasicsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: TitleBasicsDetailComponent,
    resolve: {
      titleBasics: TitleBasicsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: TitleBasicsUpdateComponent,
    resolve: {
      titleBasics: TitleBasicsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: TitleBasicsUpdateComponent,
    resolve: {
      titleBasics: TitleBasicsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
