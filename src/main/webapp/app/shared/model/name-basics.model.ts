import { ITitlePrincipals } from 'app/shared/model/title-principals.model';

export interface INameBasics {
  id?: number;
  primaryName?: string;
  birthYear?: number;
  deathYear?: number;
  primaryProfession?: string;
  knownForTitles?: string;
  titlePrincipals?: ITitlePrincipals[];
}

export class NameBasics implements INameBasics {
  constructor(
    public id?: number,
    public primaryName?: string,
    public birthYear?: number,
    public deathYear?: number,
    public primaryProfession?: string,
    public knownForTitles?: string,
    public titlePrincipals?: ITitlePrincipals[]
  ) {}
}
