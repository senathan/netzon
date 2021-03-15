import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ITitleRatings } from 'app/shared/model/title-ratings.model';

type EntityResponseType = HttpResponse<ITitleRatings>;
type EntityArrayResponseType = HttpResponse<ITitleRatings[]>;

@Injectable({ providedIn: 'root' })
export class TitleRatingsService {
  public resourceUrl = SERVER_API_URL + 'api/title-ratings';

  constructor(protected http: HttpClient) {}

  create(titleRatings: ITitleRatings): Observable<EntityResponseType> {
    return this.http.post<ITitleRatings>(this.resourceUrl, titleRatings, { observe: 'response' });
  }

  update(titleRatings: ITitleRatings): Observable<EntityResponseType> {
    return this.http.put<ITitleRatings>(this.resourceUrl, titleRatings, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ITitleRatings>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ITitleRatings[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
