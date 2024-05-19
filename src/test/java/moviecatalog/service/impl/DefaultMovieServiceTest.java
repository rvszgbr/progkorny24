package hu.nye.progkor.moviecatalog.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hu.nye.progkor.moviecatalog.data.model.Genre;
import hu.nye.progkor.moviecatalog.data.repository.Repository;
import hu.nye.progkor.moviecatalog.service.SongService;

/**
 * Unit tests for {@link DefaultSongService}.
 */
class DefaultMovieServiceTest {

    private static final Long DUMMY_MOVIE_ID = 1L;
    private static final Movie DUMMY_MOVIE = new Movie(DUMMY_MOVIE_ID, "title", "actor", "director", Genre.CLASSICAL);

    @Mock
    private Repository<Movie, Long> songRepository;

    private MovieService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultMovieService(movieRepository);
    }

    @Test
    void createSongShouldDelegateToTheRepositoryAndReturnSavedSong() {
        // Given
        given(songRepository.save(DUMMY_MOVIE)).willReturn(DUMMY_MOVIE);

        // When
        final Movie actual = underTest.createSong(DUMMY_MOVIE);

        // Then
        assertThat(actual, equalTo(DUMMY_MOVIE));
        verify(movieRepository).save(DUMMY_MOVIE);
        verifyNoMoreInteractions(movieRepository);
    }

    @Test
    void retrieveMovieByIdShouldDelegateToTheRepositoryAndReturnFoundMovie() {
        // Given
        given(movieRepository.getById(DUMMY_MOVIE_ID)).willReturn(Optional.of(DUMMY_MOVIE));

        // When
        final Optional<Movie> actual = underTest.retrieveMovieById(DUMMY_MOVIE_ID);

        // Then
        assertThat(actual, equalTo(Optional.of(MOVIE_SONG)));
        verify(movieRepository).getById(DUMMY_MOVIE_ID);
        verifyNoMoreInteractions(movieRepository);
    }

    @Test
    void retrieveAllMoviesShouldDelegateToTheRepositoryAndReturnAllFoundMovies() {
        // Given
        given(movieRepository.getAll()).willReturn(List.of(DUMMY_MOVIE));

        // When
        final List<Movie> actual = underTest.retrieveAllMovies();

        // Then
        assertThat(actual, equalTo(List.of(DUMMY_MOVIE)));
        verify(movieRepository).getAll();
        verifyNoMoreInteractions(movieRepository);
    }

    @Test
    void updateMovie() {
    }

    @Test
    void deleteMovieById() {
    }
}
