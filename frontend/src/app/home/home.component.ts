import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private _num = 1 ;
  private _res = 0 ;



  postForm = this.formBuilder.group({
    newnum: '',
  });

  currentNumForm =  this.formBuilder.group({
  });

  constructor(private _http: HttpClient, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this._http.get<number>("http://localhost:8080/adder/current", <object>this._options()).subscribe({
      next:(num: number) => this._num = num});




    //this._num = this._num + 1;
  }

  postSubmit(): void {
    // checker le postform value
    this._http.put<number>("http://localhost:8080/adder", <number>this.postForm.value.newnum, <object>this._options()).subscribe({
      next:(num: number) => this._res = num});

    // mettre a jour res
    //this._res = this.postForm.value.newnum;
  }

  private _options(headerList: object = {}): any {
    return { headers: new HttpHeaders(Object.assign({ 'Content-Type': 'application/json' }, headerList)) };
  }

  get num(): number {
    return this._num;
  }

  set num(value: number) {
    this._num = value;
  }


  get res(): number {
    return this._res;
  }

  set res(value: number) {
    this._res = value;
  }
}
