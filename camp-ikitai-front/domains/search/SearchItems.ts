/* eslint-disable no-useless-constructor */
class Item {
  constructor(public name = '', public value = '') {}
}
export default class SearchItem {
    constructor(public label = '', public items:Item[] = []) {}
  }

export const Prefectures: SearchItem[] = [
  {
    label: '関東',
    items: [
      { name: '東京', value: 'tokyo' },
      { name: '神奈川', value: 'kanagawa' },
      { name: '埼玉', value: 'saitama' },
      { name: '茨城', value: 'ibaragi' },
      { name: '群馬', value: 'gunnma' },
      { name: '栃木', value: 'tochigi' },
      { name: '千葉', value: 'chiba' },
    ],
  },
  {
    label: '北陸・甲信越',
    items: [
      { name: '新潟', value: 'niigata' },
      { name: '富山', value: 'toyama' },
      { name: '石川', value: 'ishikawa' },
      { name: '福井', value: 'fukui' },
      { name: '山梨', value: 'yamanashi' },
      { name: '長野', value: 'nagano' },
    ],
  },
]

export const Features: SearchItem[] = [
  {
    label: '施設タイプ',
    items: [
      { name: 'オートキャンプ場', value: 'autoCampSite' },
      { name: 'キャンプ場', value: 'campSite' },
      { name: 'ロッジ', value: 'lodge' },
      { name: 'バンガロー', value: 'bungalow' },
    ],
  },
  {
    label: '場内設備',
    items: [
      { name: 'お風呂', value: 'bath' },
      { name: 'シャワー', value: 'shower' },
      { name: 'ゴミ捨て場', value: 'dumpSite' },
      { name: 'ランドリー', value: 'laundry' },
    ],
  },
]
