import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { INameBasics, NameBasics } from 'app/shared/model/name-basics.model';
import { NameBasicsService } from './name-basics.service';
import { NameBasicsComponent } from './name-basics.component';
import { NameBasicsDetailComponent } from './name-basics-detail.component';
import { NameBasicsUpdateComponent } from './name-basics-update.component';

@Injectable({ providedIn: 'root' })
export class NameBasicsResolve implements Resolve<INameBasics> {
  constructor(private service: NameBasicsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<INameBasics> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((nameBasics: HttpResponse<NameBasics>) => {
          if (nameBasics.body) {
            return of(nameBasics.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new NameBasics());
  }
}

export const nameBasicsRoute: Routes = [
  {
    path: '',
    component: NameBasicsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.nameBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: NameBasicsDetailComponent,
    resolve: {
      nameBasics: NameBasicsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.nameBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: NameBasicsUpdateComponent,
    resolve: {
      nameBasics: NameBasicsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.nameBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: NameBasicsUpdateComponent,
    resolve: {
      nameBasics: NameBasicsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'netzonApp.nameBasics.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
