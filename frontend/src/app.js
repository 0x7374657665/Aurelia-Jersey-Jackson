import { HttpClient } from 'aurelia-fetch-client'
import environment from './environment'

export class App {
  constructor() {
    this.message = 'Steve was here.';
  }

  activate() {
    console.log('activate callback called')
    let httpClient = new HttpClient()

    httpClient.fetch(`${environment.host}backend/api/myresource/json`)
      .then(response => {
        console.log('response recieved:', response)
        return response.json()
      }).then(data => {
        console.log('parsed return data:', data)
        this.message = `lucky #${data.luckyNum} says: ${data.message}`
      })
  }
}
