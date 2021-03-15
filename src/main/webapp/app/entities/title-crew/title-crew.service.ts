import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ITitleCrew } from 'app/shared/model/title-crew.model';

type EntityResponseType = HttpResponse<ITitleCrew>;
type EntityArrayResponseType = HttpResponse<ITitleCrew[]>;

@Injectable({ providedIn: 'root' })
export class TitleCrewService {
  public resourceUrl = SERVER_API_URL + 'api/title-crews';

  constructor(protected http: HttpClient) {}

  create(titleCrew: ITitleCrew): Observable<EntityResponseType> {
    return this.http.post<ITitleCrew>(this.resourceUrl, titleCrew, { observe: 'response' });
  }

  update(titleCrew: ITitleCrew): Observable<EntityResponseType> {
    return this.http.put<ITitleCrew>(this.resourceUrl, titleCrew, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ITitleCrew>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ITitleCrew[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
