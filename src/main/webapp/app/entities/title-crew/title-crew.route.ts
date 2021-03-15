import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ITitleCrew, TitleCrew } from 'app/shared/model/title-crew.model';
import { TitleCrewService } from './title-crew.service';
import { TitleCrewComponent } from './title-crew.component';
import { TitleCrewDetailComponent } from './title-crew-detail.component';
import { TitleCrewUpdateComponent } from './title-crew-update.component';

@Injectable({ providedIn: 'root' })
export class TitleCrewResolve implements Resolve<ITitleCrew> {
  constructor(private service: TitleCrewService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ITitleCrew> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((titleCrew: HttpResponse<TitleCrew>) => {
          if (titleCrew.body) {
            return of(titleCrew.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new TitleCrew());
  }
}

export const titleCrewRoute: Routes = [
  {
    path: '',
    component: TitleCrewComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleCrew.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: TitleCrewDetailComponent,
    resolve: {
      titleCrew: TitleCrewResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleCrew.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: TitleCrewUpdateComponent,
    resolve: {
      titleCrew: TitleCrewResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleCrew.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: TitleCrewUpdateComponent,
    resolve: {
      titleCrew: TitleCrewResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.titleCrew.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
