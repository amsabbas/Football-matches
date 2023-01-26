//
//  MatchesViewModel.swift
//  ios
//
//  Created by Ahmed Mohamed on 24/01/2023.
//

import Foundation

import shared
import Combine


class MatchesViewModel: ObservableObject {
    
    private var useCase: MatchesUseCase?

    let matchesDays : Int = 38
    
    @Published var matchesResource = Resource<Matches>.idle
    @Published var weekdaySelectedTabIndex:Int = 0
    
    init() {
        self.useCase = MatchesUseCase(matchesRepository: MatchesRepository(remoteDataSource: MatchesRemoteDataSource(ktorHttpClient: KtorHttpClient(), matchesMemoryCache: MatchesMemoryCache(matches: nil))))
    }
    
    func getMatches(){
        matchesResource = Resource.loading
        Task {
            do{
                try await useCase?.getMatches(matchDay: Int32(weekdaySelectedTabIndex + 1)).collect(collector: Collector<Matches> { value in
                    DispatchQueue.main.async {   // <====
                        self.matchesResource = Resource.success(value)
                    }
                })
            }catch let error {
                DispatchQueue.main.async {   // <====
                    self.matchesResource = Resource.error(error as! AppException)
                }
       
            }
        }
    }
}
