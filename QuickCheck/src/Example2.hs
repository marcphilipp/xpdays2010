import Data.Char
import Test.QuickCheck
 
-- A thin monadic skin layer
getList :: IO [Char]
getList = fmap take5 getContents
 
-- The actual worker
take5 :: [Char] -> [Char]
take5 = take 5 . filter (`elem` ['a'..'e'])


instance Arbitrary Char where
    arbitrary     = choose ('\32', '\128')
    coarbitrary c = variant (ord c `rem` 4)

deepCheck p = check (defaultConfig { configMaxTest = 10000}) p
