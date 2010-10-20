module Paths_QuickCheck (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName
  ) where

import Data.Version (Version(..))
import System.Environment (getEnv)

version :: Version
version = Version {versionBranch = [0,1], versionTags = []}

bindir, libdir, datadir, libexecdir :: FilePath

bindir     = "/Users/mphilipp/.cabal/bin"
libdir     = "/Users/mphilipp/.cabal/lib/QuickCheck-0.1/ghc-6.12.3"
datadir    = "/Users/mphilipp/.cabal/share/QuickCheck-0.1"
libexecdir = "/Users/mphilipp/.cabal/libexec"

getBinDir, getLibDir, getDataDir, getLibexecDir :: IO FilePath
getBinDir = catch (getEnv "QuickCheck_bindir") (\_ -> return bindir)
getLibDir = catch (getEnv "QuickCheck_libdir") (\_ -> return libdir)
getDataDir = catch (getEnv "QuickCheck_datadir") (\_ -> return datadir)
getLibexecDir = catch (getEnv "QuickCheck_libexecdir") (\_ -> return libexecdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
