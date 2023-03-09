import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
// import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {

  fileUploadUrl = "http://localhost:8081/employee/upload";
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
  }

  file:any;
  flag = true;

  selectFile(event){
    console.log(event);
    this.file = event.target.files[0];
    console.log(this.file);

  }

  uploadFile(){
    let formData = new FormData();
    formData.append('file', this.file);
    this.flag = false;
    this.http.post(this.fileUploadUrl, formData, {responseType: 'text'}).subscribe(
      (data: any) => {
        // responseType
        // success
       
        console.log(data);
        this.flag = true;
        alert("File Uploaded Successfully!");  
      },
      )
    
  }

}
