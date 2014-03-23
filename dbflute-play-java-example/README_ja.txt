
# ========================================================================================
#                                                                                 Overview
#                                                                                 ========
SAStruts と DBFlute を組み合わせた Example プロジェクトです。

このExampleには以下の目的があります：
  o WEBアプリ(SAStruts)におけるDBFluteの利用イメージを掴んでもらう
  o ちょっとした検証などが可能な環境の提供
  o 実際にSAStrutsを利用するときの環境構築の土台
   -> 詳しくは "Application Use" の欄をご覧下さい 


# ========================================================================================
#                                                                              Environment
#                                                                              ===========
# ----------------------------------------------------------
#                                             Source Compile
#                                             --------------
Maven管理されていますので、動作させるためには M2E などを用意してください。

# ----------------------------------------------------------
#                                                   Database
#                                                   --------
データベースは、H2 Database を組み込みで利用しているため、特に準備せずに利用できます。
(データベースのデータファイルは src/main/resources/exampledb に配置されています)

# ----------------------------------------------------------
#                                                   Web Boot
#                                                   --------
Run Jetty Run プグラインを利用します。(Eclipse Marketplace からインストール可能)
Eclipseプロジェクトを選択して右クリックして "Run as" - "Run Jetty" を選択、
これで、以下のURLでアクセスすると画面を動かすことができます。

 http://localhost:8080/sastruts/

以降は、ツールバーの Launch ボタン (緑丸に右">"マーク) を押すだけで再起動します。
細かい起動設定は、Run as Configurations... から調整できます。

※jetty-web.xml の設定で、コンテキスト名が sastruts となる


# ========================================================================================
#                                                                          Application Use
#                                                                          ===============
アプリケーションの環境構築の土台として利用するやり方の手順です。
この Example プロジェクトをそのまま修正して「自分のプロジェクト用」にしていきます。

ここでは、シンプルな「一つのプロジェクト、一つのアプリ」を想定しています。
また、ひとまずはデータベースをそのまま流用します。
名前などが一通り自分のプロジェクト用に直しても動く状態から、
データベースもプロジェクト用にしていく方がやりやすいと思われるためです。

# ----------------------------------------------------------
#                                                Basic Setup
#                                                -----------
このプロジェクトをチェックアウトし、SVN から切断を切る。(SVNメタデータも削除してOK)
そして、com.example.dbflute.sastruts などの名前をひたすら名前を変更していきます。

  o Eclipseプロジェクト名(dbflute-sastruts-example)を修正
  o src/main/java, src/test/java の com.example.dbflute.sastruts パッケージを一括修正
     -> リファクタリングは alt + shift + R (alt + command + R in Mac)
     -> org.dbflute.safluteのパッケージはそのまま (便利なクラスなのでそのまま利用でOK)
  o convention.dicon のルートパッケージの設定を修正
  o log4j.properties の domain.name, basedir, application logger などを修正
  o pom.xml の artifactId, groupId, dependencies などを修正
  o jetty-web.xml のコンテキスト名を修正
  o DBFluteクライアント(dbflute_exampledb)配下の exampledb の部分を修正
  　 -> build.properties, _project.bat, _project.sh
  o DBFluteクライアントのディレクトリ(dbflute_exampledb)の名前も修正
  o オープンソース関連ファイルを削除 (LICENSE, NOTICE, README, thanks.txt など)

この時点で Jetty で動作させて、想定したURLで画面が動くかどうか確認しましょう。

# ----------------------------------------------------------
#                                                  Genba Fit
#                                                  ---------
さて、ここからは現場フィットです。
DBFluteは、一度削除してから EMecha でインストールし直しても、
既に存在しているDBFluteを修正して利用するのでも、どちらもで構いません。

いずれにせよ、データベースの準備(DB設計してDDLを用意)をして、
ReplaceSchemaの環境構築をして実行してスキーマを構築して、
dfpropファイルをもろもろ修正して自動生成をしていきます。

主な修正対象dfpropファイル：

  o basicInfoMap.dfprop -> database, packageBase
  o databaseInfoMap.dfprop -> DB接続情報
  o additionalForeignKeyMap.dfprop -> ExampleDBのものを参考に自分用に
  o classificationDefinitionMap.dfprop -> ExampleDBのものを参考に自分用に
  o classificationDeploymentMap.dfprop -> ExampleDBのものを参考に自分用に
  o commonColumnMap.dfprop -> ExampleDBのものを参考に自分用に
  o allClassCopyright.dfprop -> コピーライトが不要であれば削除でOK
  o refreshDefinitionMap.dfprop -> F5対象のプロジェクト名

さて、あとは臨機に修正していってください。全ての情報がここにあるわけではありません。
迷う場合や悩むことがあれば、DBFluteユーザの集いなどのMLで質問(フィードバック)すると良いでしょう。

http://dbflute.seasar.org/ja/manual/topic/office/feedback.html
