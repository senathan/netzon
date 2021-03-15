import { ITitleCrew } from 'app/shared/model/title-crew.model';
import { ITitleRatings } from 'app/shared/model/title-ratings.model';
import { ITitlePrincipals } from 'app/shared/model/title-principals.model';

export interface ITitleBasics {
  id?: number;
  titleType?: string;
  primaryTitle?: string;
  originalTitle?: string;
  isAdult?: boolean;
  startYear?: number;
  endYear?: number;
  runTimeMinutes?: number;
  genres?: string;
  titleCrews?: ITitleCrew[];
  titleRatings?: ITitleRatings[];
  titlePrincipals?: ITitlePrincipals[];
}

export class TitleBasics implements ITitleBasics {
  constructor(
    public id?: number,
    public titleType?: string,
    public primaryTitle?: string,
    public originalTitle?: string,
    public isAdult?: boolean,
    public startYear?: number,
    public endYear?: number,
    public runTimeMinutes?: number,
    public genres?: string,
    public titleCrews?: ITitleCrew[],
    public titleRatings?: ITitleRatings[],
    public titlePrincipals?: ITitlePrincipals[]
  ) {
    this.isAdult = this.isAdult || false;
  }
}
