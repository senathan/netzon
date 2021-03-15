import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { INameBasics } from 'app/shared/model/name-basics.model';

type EntityResponseType = HttpResponse<INameBasics>;
type EntityArrayResponseType = HttpResponse<INameBasics[]>;

@Injectable({ providedIn: 'root' })
export class NameBasicsService {
  public resourceUrl = SERVER_API_URL + 'api/name-basics';

  constructor(protected http: HttpClient) {}

  create(nameBasics: INameBasics): Observable<EntityResponseType> {
    return this.http.post<INameBasics>(this.resourceUrl, nameBasics, { observe: 'response' });
  }

  update(nameBasics: INameBasics): Observable<EntityResponseType> {
    return this.http.put<INameBasics>(this.resourceUrl, nameBasics, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<INameBasics>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<INameBasics[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
