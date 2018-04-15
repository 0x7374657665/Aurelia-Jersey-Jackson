import webpackConfig from '../../webpack.config';
import webpack from 'webpack';
import project from '../aurelia.json';
import {CLIOptions, Configuration} from 'aurelia-cli';
import gulp from 'gulp';
import configureEnvironment from './environment';
import del from 'del';
import copyToBackend from './copy-to-backend';

const analyze = CLIOptions.hasFlag('analyze');
const buildOptions = new Configuration(project.build.options);
const production = CLIOptions.getEnvironment() === 'prod';
const server = buildOptions.isApplicable('server');
const extractCss = buildOptions.isApplicable('extractCss');
const coverage = buildOptions.isApplicable('coverage');

const contextPath = production ? 'backend' : ''

const config = webpackConfig({
  production, server, extractCss, coverage, analyze, contextPath
});
const compiler = webpack(config);

function buildWebpack(done) {
  if (CLIOptions.hasFlag('watch')) {
    compiler.watch({}, onBuild);
  } else {
    compiler.run(onBuild);
    compiler.plugin('done', () => done());
  }
}

function onBuild(err, stats) {
  if (err) {
    console.error(err.stack || err);
    if (err.details) console.error(err.details);
    process.exit(1);
  } else {
    process.stdout.write(stats.toString({ colors: require('supports-color') }) + '\n');
  }
}

function clearDist() {
  return del([config.output.path]);
}

function packageJSInWar() {
  if(production) copyToBackend()
}

const build = gulp.series(
  clearDist,
  configureEnvironment,
  buildWebpack,
  packageJSInWar
);

export {
  config,
  buildWebpack,
  build as default
};
