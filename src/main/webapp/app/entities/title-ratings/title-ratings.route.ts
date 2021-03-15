import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ITitleRatings, TitleRatings } from 'app/shared/model/title-ratings.model';
import { TitleRatingsService } from './title-ratings.service';
import { TitleRatingsComponent } from './title-ratings.component';
import { TitleRatingsDetailComponent } from './title-ratings-detail.component';
import { TitleRatingsUpdateComponent } from './title-ratings-update.component';

@Injectable({ providedIn: 'root' })
export class TitleRatingsResolve implements Resolve<ITitleRatings> {
  constructor(private service: TitleRatingsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ITitleRatings> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((titleRatings: HttpResponse<TitleRatings>) => {
          if (titleRatings.body) {
            return of(titleRatings.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new TitleRatings());
  }
}

export const titleRatingsRoute: Routes = [
  {
    path: '',
    component: TitleRatingsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleRatings.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: TitleRatingsDetailComponent,
    resolve: {
      titleRatings: TitleRatingsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleRatings.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: TitleRatingsUpdateComponent,
    resolve: {
      titleRatings: TitleRatingsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleRatings.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: TitleRatingsUpdateComponent,
    resolve: {
      titleRatings: TitleRatingsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleRatings.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
