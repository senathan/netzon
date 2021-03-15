import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ITitleRatings, TitleRatings } from 'app/shared/model/title-ratings.model';
import { TitleRatingsService } from './title-ratings.service';
import { ITitleBasics } from 'app/shared/model/title-basics.model';
import { TitleBasicsService } from 'app/entities/title-basics/title-basics.service';

@Component({
  selector: 'jhi-title-ratings-update',
  templateUrl: './title-ratings-update.component.html',
})
export class TitleRatingsUpdateComponent implements OnInit {
  isSaving = false;
  titlebasics: ITitleBasics[] = [];

  editForm = this.fb.group({
    id: [],
    numvotes: [],
    averageRating: [],
    titleBasics: [],
  });

  constructor(
    protected titleRatingsService: TitleRatingsService,
    protected titleBasicsService: TitleBasicsService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ titleRatings }) => {
      this.updateForm(titleRatings);

      this.titleBasicsService.query().subscribe((res: HttpResponse<ITitleBasics[]>) => (this.titlebasics = res.body || []));
    });
  }

  updateForm(titleRatings: ITitleRatings): void {
    this.editForm.patchValue({
      id: titleRatings.id,
      numvotes: titleRatings.numvotes,
      averageRating: titleRatings.averageRating,
      titleBasics: titleRatings.titleBasics,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const titleRatings = this.createFromForm();
    if (titleRatings.id !== undefined) {
      this.subscribeToSaveResponse(this.titleRatingsService.update(titleRatings));
    } else {
      this.subscribeToSaveResponse(this.titleRatingsService.create(titleRatings));
    }
  }

  private createFromForm(): ITitleRatings {
    return {
      ...new TitleRatings(),
      id: this.editForm.get(['id'])!.value,
      numvotes: this.editForm.get(['numvotes'])!.value,
      averageRating: this.editForm.get(['averageRating'])!.value,
      titleBasics: this.editForm.get(['titleBasics'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ITitleRatings>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: ITitleBasics): any {
    return item.id;
  }
}
