import { ITitleBasics } from 'app/shared/model/title-basics.model';
import { INameBasics } from 'app/shared/model/name-basics.model';

export interface ITitlePrincipals {
  id?: number;
  category?: string;
  job?: string;
  characters?: string;
  titleBasics?: ITitleBasics;
  nameBasics?: INameBasics;
}

export class TitlePrincipals implements ITitlePrincipals {
  constructor(
    public id?: number,
    public category?: string,
    public job?: string,
    public characters?: string,
    public titleBasics?: ITitleBasics,
    public nameBasics?: INameBasics
  ) {}
}
