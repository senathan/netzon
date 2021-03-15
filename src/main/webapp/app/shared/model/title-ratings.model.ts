import { ITitleBasics } from 'app/shared/model/title-basics.model';

export interface ITitleRatings {
  id?: number;
  numvotes?: number;
  averageRating?: number;
  titleBasics?: ITitleBasics;
}

export class TitleRatings implements ITitleRatings {
  constructor(public id?: number, public numvotes?: number, public averageRating?: number, public titleBasics?: ITitleBasics) {}
}
