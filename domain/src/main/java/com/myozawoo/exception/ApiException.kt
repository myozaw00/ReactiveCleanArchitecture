package com.myozawoo.exception

class ApiException(val errorMessage: String): Exception(errorMessage)