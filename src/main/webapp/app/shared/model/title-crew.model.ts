import { ITitleBasics } from 'app/shared/model/title-basics.model';

export interface ITitleCrew {
  id?: number;
  directors?: string;
  writers?: string;
  titleBasics?: ITitleBasics;
}

export class TitleCrew implements ITitleCrew {
  constructor(public id?: number, public directors?: string, public writers?: string, public titleBasics?: ITitleBasics) {}
}
