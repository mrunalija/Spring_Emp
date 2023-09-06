package com.amdocs.spring.exceptions;

import java.time.LocalDateTime;

public class errorDetails {
		String message;
		int statusCode;
		LocalDateTime datetime;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public int getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}
		public LocalDateTime getDatetime() {
			return datetime;
		}
		public void setDatetime(LocalDateTime datetime) {
			this.datetime = datetime;
		}
		public errorDetails(String message, int statusCode, LocalDateTime datetime) {
			super();
			this.message = message;
			this.statusCode = statusCode;
			this.datetime = datetime;
		}
		public errorDetails() {
			super();
		}
		

}
