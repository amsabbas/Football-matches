//
//  ExceptionExtension.swift
//  ios
//
//  Created by Ahmed Mohamed on 26/01/2023.
//

import Foundation
import shared

extension AppException{

    func getErrorMessage() -> String {
        
        if (self.exceptionType == AppExceptionType.unauthorized ){
            return "UnAuthorized, please re-login"
        }
        else  if (self.exceptionType == AppExceptionType.api ){
            return self.message ?? ""
        }
        else  if (self.exceptionType == AppExceptionType.network ){
            return "Please make sure you are connected to the internet"
        }else {
            return "Unknown error, please try again"
        }
    }
}
