//
//  Resource.swift
//  ios
//
//  Created by Ahmed Mohamed on 25/01/2023.
//

import Foundation
import shared

enum Resource<Value> {
        case idle
        case loading
        case error(AppException)
        case success(Value)
}
