
# ========================================================================================
#                                                                                 Overview
#                                                                                 ========
Play (Java) と DBFlute を組み合わせた Example プロジェクトです。


# ========================================================================================
#                                                                              Environment
#                                                                              ===========
# ----------------------------------------------------------
#                                               Precondition
#                                               ------------
環境構築は、Eclipseを前提としています。
(他のIDEでも利用できるかと思いますが、特に手順はありません)

Eclipse の .project ファイルはコミットされているので Git から clone して、
そのまま Eclipse で認識できますが、.classpath は Play で生成する必要があります。
ただ、アプリの起動は、Eclipse上でのコンパイルは関係ないので play コマンドから実行できます。

一方で、データベースは、H2 Database を利用しているので、特に準備は不要です。

# ----------------------------------------------------------
#                                                 Setup Flow
#                                                 ----------
1. etc/tools/の下に Play を配置

Play のバージョンは 2.2.2 です。

http://downloads.typesafe.com/play/2.2.2/play-2.2.2.zip
をダウンロードして、以下のように配置してください。

dbflute-play-java-example
 |-dbflute_exampledb
 |-etc
 |  |-license
 |  |-tools
 |  |  |-play // *here
 |  |  |  |-framework
 |  |  |  |-repository
 |  |  |  |-samples
 |  |  |  |-play
 |  |  |  |-...
 |  |-play.sh // すると、この sh が使えるようになる
 |  |-sbt.sh
 |-mydbflute
 |-...

すると、play.sh を使って play コマンドが叩けるようになります。
playディレクトリは、gitignoreになっているのでコミット対象にはなりません。

※もちろん、ローカルPCの任意の場所に Play をインストールして、
pathを通すやり方でも構いません。

e.g.
  $ export PLAY_HOME=${HOME}/java/play-2.2.2
  $ PATH=${PLAY_HOME}:${PATH}
  $ export PATH


2. まずは画面を起動してみましょう

play.sh を叩くと、playと対話モードになります。
そこで、run というコマンドを入力して実行してください。

/- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
       _
 _ __ | | __ _ _  _
| '_ \| |/ _' | || |
|  __/|_|\____|\__ /
|_|            |__/

play 2.2.2 built with Scala 2.10.3 (running Java 1.7.0_25), http://www.playframework.com

> Type "help play" or "license" for more information.
> Type "exit" or use Ctrl+D to leave this console.

[dbflute-play-java-example] $ run

--- (Running the application from SBT, auto-reloading is enabled) ---

[info] play - Listening for HTTP on /0:0:0:0:0:0:0:0:9000

(Server started, use Ctrl+D to stop and go back to the console...)
- - - - - - - - - -/

「Server started」が表示されたらブラウザにて、

http://localhost:9000/

にアクセスしてみてください。会員一覧画面が表示されます。
(初回はコンパイルが走るので何十秒か時間が掛かります)


3. Eclipse 上でコンパイルできるように (.classpath)

playコマンドで .classpath を生成します。

play.sh を叩いて play の対話モードにして、
「eclipse with-source=true」というコマンドを入力して実行してください。

/- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
[dbflute-play-java-example] $ eclipse with-source=true
- - - - - - - - - -/

すると、.classpathが自動生成され、Eclipse上でコンパイルできるようになります。
(Eclipse上で F5 をしましょう)


4. 必要に応じて、Scala IDE プラグインをインストール

// Scala IDE トップページ
http://scala-ide.org/

から、
利用している Eclipse のバージョンに対応した update site のURLを探し、
(変わってなければこのページ: http://scala-ide.org/download/current.html)

Eclipse の update site に追加して、以下の二つのプラグインをインストールする。

- Scala IDE for Eclipse
- Play2 support in Scala IDE

