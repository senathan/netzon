import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITitleCrew } from 'app/shared/model/title-crew.model';

@Component({
  selector: 'jhi-title-crew-detail',
  templateUrl: './title-crew-detail.component.html',
})
export class TitleCrewDetailComponent implements OnInit {
  titleCrew: ITitleCrew | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ titleCrew }) => (this.titleCrew = titleCrew));
  }

  previousState(): void {
    window.history.back();
  }
}
