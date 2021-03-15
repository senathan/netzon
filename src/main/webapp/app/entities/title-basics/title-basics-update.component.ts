import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ITitleBasics, TitleBasics } from 'app/shared/model/title-basics.model';
import { TitleBasicsService } from './title-basics.service';

@Component({
  selector: 'jhi-title-basics-update',
  templateUrl: './title-basics-update.component.html',
})
export class TitleBasicsUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    titleType: [],
    primaryTitle: [],
    originalTitle: [],
    isAdult: [],
    startYear: [],
    endYear: [],
    runTimeMinutes: [],
    genres: [],
  });

  constructor(protected titleBasicsService: TitleBasicsService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ titleBasics }) => {
      this.updateForm(titleBasics);
    });
  }

  updateForm(titleBasics: ITitleBasics): void {
    this.editForm.patchValue({
      id: titleBasics.id,
      titleType: titleBasics.titleType,
      primaryTitle: titleBasics.primaryTitle,
      originalTitle: titleBasics.originalTitle,
      isAdult: titleBasics.isAdult,
      startYear: titleBasics.startYear,
      endYear: titleBasics.endYear,
      runTimeMinutes: titleBasics.runTimeMinutes,
      genres: titleBasics.genres,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const titleBasics = this.createFromForm();
    if (titleBasics.id !== undefined) {
      this.subscribeToSaveResponse(this.titleBasicsService.update(titleBasics));
    } else {
      this.subscribeToSaveResponse(this.titleBasicsService.create(titleBasics));
    }
  }

  private createFromForm(): ITitleBasics {
    return {
      ...new TitleBasics(),
      id: this.editForm.get(['id'])!.value,
      titleType: this.editForm.get(['titleType'])!.value,
      primaryTitle: this.editForm.get(['primaryTitle'])!.value,
      originalTitle: this.editForm.get(['originalTitle'])!.value,
      isAdult: this.editForm.get(['isAdult'])!.value,
      startYear: this.editForm.get(['startYear'])!.value,
      endYear: this.editForm.get(['endYear'])!.value,
      runTimeMinutes: this.editForm.get(['runTimeMinutes'])!.value,
      genres: this.editForm.get(['genres'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ITitleBasics>>): void {
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
}
