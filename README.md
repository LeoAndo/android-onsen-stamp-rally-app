# アプリ概要

このアプリは、銭湯のスタンプラリーをしているユーザー向けのスタンプ管理アプリになります。<br>
スタンプ管理以外にも、各銭湯の詳細画面から外部アプリ「Google Map, GMail, Phone, Twitter, Facebook, Browser」などを起動し、銭湯の詳細情報をすぐに確認できるところがポイントです。<br>
また、ビルドタイプを切り替えるだけで同じようなアプリを作る仕組みにしているのも特徴です。<br>

# キャプチャ (東京ゆらん 2021)

## Pixcel 5 OS 12

| Part1 | Part2 |
|:---|:---:|
|<img src="https://github.com/LeoAndo/android-onsen-stamp-rally-app/blob/main/capture/tokyo_yuran2021_os12_part1.gif" width=320 /> |<img src="https://github.com/LeoAndo/android-onsen-stamp-rally-app/blob/main/capture/tokyo_yuran2021_os12_part2.gif" width=320 /> |

# キャプチャ (浅草湯めぐり 2021)

## Pixcel 5 OS 12

| Part1 |
|:---|
|<img src="https://github.com/LeoAndo/android-onsen-stamp-rally-app/blob/main/capture/asakusa_yumeguri2021_os12_part1.gif" width=320 /> |


# アーキテクチャ

- Single Module, Single Activity, MVVMを採用
  - [参考](https://developer.android.com/jetpack/guide?hl=ja#overview)
- Product Flavorを使用しバージョン管理
  - [参考](https://developer.android.com/studio/build/build-variants?hl=ja)
- Jetpack Compose未使用 (従来のViewの実装を採用)

# UI デザイン
[Material Design 3](https://m3.material.io/)を採用

# 実装方針

- UI Layer
  - Activity
    - Toolbar, FloatingActionButton, NavigationViewを持つ
    - NavHostFragmentを１つ持つ
  - Fragment
    - 画面遷移は、Navigation Graphを使用する
    - Toolbarを持たない
    - viewModelで定義されている１つのLiveDataを監視し、UI更新を行う
  - viewModel
    - try catchはviewModelで行う
    - Fragmentに処理結果を返す手段はLivedata
    - １つのLiveDataを定義し、値はseald interfaceで定義されたオブジェクトを指定する
    - FlowのcollectはviewModelで行う

- domain Layer
  - 作成していない 

- data Layer
  - [room](https://developer.android.com/training/data-storage/room?hl=ja)を使用してローカルデータベースを管理

# ソースコード

## 共通コード

[共通コード](https://github.com/LeoAndo/android-onsen-stamp-rally-app/tree/main/OnsenStampRallyApp/app/src/main)<br>
[東京ゆらん 2021専用コード](https://github.com/LeoAndo/android-onsen-stamp-rally-app/tree/main/OnsenStampRallyApp/app/src/tokyoyuran2021)<br>
[浅草湯めぐり 2021専用コード](https://github.com/LeoAndo/android-onsen-stamp-rally-app/tree/main/OnsenStampRallyApp/app/src/asakusayumeguri2021)<br>

# 使用ライブラリ

https://github.com/LeoAndo/android-onsen-stamp-rally-app/blob/main/OnsenStampRallyApp/app/build.gradle#L58:L86
