import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITitleRatings } from 'app/shared/model/title-ratings.model';

@Component({
  selector: 'jhi-title-ratings-detail',
  templateUrl: './title-ratings-detail.component.html',
})
export class TitleRatingsDetailComponent implements OnInit {
  titleRatings: ITitleRatings | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ titleRatings }) => (this.titleRatings = titleRatings));
  }

  previousState(): void {
    window.history.back();
  }
}
