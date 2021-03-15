import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { INameBasics, NameBasics } from 'app/shared/model/name-basics.model';
import { NameBasicsService } from './name-basics.service';

@Component({
  selector: 'jhi-name-basics-update',
  templateUrl: './name-basics-update.component.html',
})
export class NameBasicsUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    primaryName: [],
    birthYear: [],
    deathYear: [],
    primaryProfession: [],
    knownForTitles: [],
  });

  constructor(protected nameBasicsService: NameBasicsService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ nameBasics }) => {
      this.updateForm(nameBasics);
    });
  }

  updateForm(nameBasics: INameBasics): void {
    this.editForm.patchValue({
      id: nameBasics.id,
      primaryName: nameBasics.primaryName,
      birthYear: nameBasics.birthYear,
      deathYear: nameBasics.deathYear,
      primaryProfession: nameBasics.primaryProfession,
      knownForTitles: nameBasics.knownForTitles,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const nameBasics = this.createFromForm();
    if (nameBasics.id !== undefined) {
      this.subscribeToSaveResponse(this.nameBasicsService.update(nameBasics));
    } else {
      this.subscribeToSaveResponse(this.nameBasicsService.create(nameBasics));
    }
  }

  private createFromForm(): INameBasics {
    return {
      ...new NameBasics(),
      id: this.editForm.get(['id'])!.value,
      primaryName: this.editForm.get(['primaryName'])!.value,
      birthYear: this.editForm.get(['birthYear'])!.value,
      deathYear: this.editForm.get(['deathYear'])!.value,
      primaryProfession: this.editForm.get(['primaryProfession'])!.value,
      knownForTitles: this.editForm.get(['knownForTitles'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<INameBasics>>): void {
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
