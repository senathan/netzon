import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITitleBasics } from 'app/shared/model/title-basics.model';

@Component({
  selector: 'jhi-title-basics-detail',
  templateUrl: './title-basics-detail.component.html',
})
export class TitleBasicsDetailComponent implements OnInit {
  titleBasics: ITitleBasics | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ titleBasics }) => (this.titleBasics = titleBasics));
  }

  previousState(): void {
    window.history.back();
  }
}
