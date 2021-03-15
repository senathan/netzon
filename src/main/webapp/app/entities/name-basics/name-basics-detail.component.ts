import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { INameBasics } from 'app/shared/model/name-basics.model';

@Component({
  selector: 'jhi-name-basics-detail',
  templateUrl: './name-basics-detail.component.html',
})
export class NameBasicsDetailComponent implements OnInit {
  nameBasics: INameBasics | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ nameBasics }) => (this.nameBasics = nameBasics));
  }

  previousState(): void {
    window.history.back();
  }
}
