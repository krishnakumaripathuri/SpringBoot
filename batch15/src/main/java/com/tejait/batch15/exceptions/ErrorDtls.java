package com.tejait.batch15.exceptions;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Data
public class ErrorDtls {
Date timestamp;
int Status;
String error;
String message;
String path;
public ErrorDtls(Date timestamp, int status, String error, String message, String path) {
	super();
	this.timestamp = timestamp;
	Status = status;
	this.error = error;
	this.message = message;
	this.path = path;
}
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
public int getStatus() {
	return Status;
}
public void setStatus(int status) {
	Status = status;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
@Override
public String toString() {
	return "ErrorDtls [timestamp=" + timestamp + ", Status=" + Status + ", error=" + error + ", message=" + message
			+ ", path=" + path + "]";
}


}
