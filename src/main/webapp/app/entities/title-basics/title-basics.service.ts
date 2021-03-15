import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ITitleBasics } from 'app/shared/model/title-basics.model';

type EntityResponseType = HttpResponse<ITitleBasics>;
type EntityArrayResponseType = HttpResponse<ITitleBasics[]>;

@Injectable({ providedIn: 'root' })
export class TitleBasicsService {
  public resourceUrl = SERVER_API_URL + 'api/title-basics';

  constructor(protected http: HttpClient) {}

  create(titleBasics: ITitleBasics): Observable<EntityResponseType> {
    return this.http.post<ITitleBasics>(this.resourceUrl, titleBasics, { observe: 'response' });
  }

  update(titleBasics: ITitleBasics): Observable<EntityResponseType> {
    return this.http.put<ITitleBasics>(this.resourceUrl, titleBasics, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ITitleBasics>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ITitleBasics[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
