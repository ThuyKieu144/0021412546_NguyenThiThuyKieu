import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userEmail: string | null = null; // Initialize email as null

  // Method to set the user's email
  setUserEmail(email: string) {
    this.userEmail = email;
  }

  // Method to get the user's email
  getUserEmail(): string | null {
    return this.userEmail;
  }

  logout(): void {
    localStorage.removeItem('userEmail'); // Ví dụ: xóa email trong localStorage
  }
  
}
