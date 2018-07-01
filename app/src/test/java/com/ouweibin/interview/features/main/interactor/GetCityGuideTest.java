package com.ouweibin.interview.features.main.interactor;

import com.ouweibin.interview.UnitTest;
import com.ouweibin.interview.core.exception.Failure;
import com.ouweibin.interview.core.functional.Either;
import com.ouweibin.interview.features.main.bean.CityGuide;
import com.ouweibin.interview.features.main.data.repository.CityGuideRepository;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;

public class GetCityGuideTest extends UnitTest{
    private GetCityGuide getCityGuides;

    @Mock
    private CityGuideRepository cityGuideRepository;

    @Before
    public void setUp() {
        getCityGuides = new GetCityGuide(cityGuideRepository);
        Mockito.when(cityGuideRepository.cityGuides()).thenReturn(new Either.Right<>(Arrays.asList(CityGuide.Companion.empty())));
    }

    @Test
    public void shouldGetDataFromRepository() {
        getCityGuides.run(new GetCityGuide.Params(-1), new Continuation<Either<? extends Failure, ? extends List<CityGuide>>>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return null;
            }

            @Override
            public void resume(Either<? extends Failure, ? extends List<CityGuide>> either) {

            }

            @Override
            public void resumeWithException(Throwable throwable) {

            }
        });

        Mockito.verify(cityGuideRepository).cityGuides();
        Mockito.verifyNoMoreInteractions(cityGuideRepository);
    }
}
