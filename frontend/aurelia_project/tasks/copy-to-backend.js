import gulp from 'gulp';
import project from '../aurelia.json';

export default function copyToBackend() {
  return gulp.src(project.paths.dist, {base: 'dist'})
    .pipe(gulp.dest(project.paths.backend));
}

