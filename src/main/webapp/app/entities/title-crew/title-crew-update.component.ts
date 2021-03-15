import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ITitleCrew, TitleCrew } from 'app/shared/model/title-crew.model';
import { TitleCrewService } from './title-crew.service';
import { ITitleBasics } from 'app/shared/model/title-basics.model';
import { TitleBasicsService } from 'app/entities/title-basics/title-basics.service';

@Component({
  selector: 'jhi-title-crew-update',
  templateUrl: './title-crew-update.component.html',
})
export class TitleCrewUpdateComponent implements OnInit {
  isSaving = false;
  titlebasics: ITitleBasics[] = [];

  editForm = this.fb.group({
    id: [],
    directors: [],
    writers: [],
    titleBasics: [],
  });

  constructor(
    protected titleCrewService: TitleCrewService,
    protected titleBasicsService: TitleBasicsService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ titleCrew }) => {
      this.updateForm(titleCrew);

      this.titleBasicsService.query().subscribe((res: HttpResponse<ITitleBasics[]>) => (this.titlebasics = res.body || []));
    });
  }

  updateForm(titleCrew: ITitleCrew): void {
    this.editForm.patchValue({
      id: titleCrew.id,
      directors: titleCrew.directors,
      writers: titleCrew.writers,
      titleBasics: titleCrew.titleBasics,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const titleCrew = this.createFromForm();
    if (titleCrew.id !== undefined) {
      this.subscribeToSaveResponse(this.titleCrewService.update(titleCrew));
    } else {
      this.subscribeToSaveResponse(this.titleCrewService.create(titleCrew));
    }
  }

  private createFromForm(): ITitleCrew {
    return {
      ...new TitleCrew(),
      id: this.editForm.get(['id'])!.value,
      directors: this.editForm.get(['directors'])!.value,
      writers: this.editForm.get(['writers'])!.value,
      titleBasics: this.editForm.get(['titleBasics'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ITitleCrew>>): void {
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
