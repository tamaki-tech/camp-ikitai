import { SearchItems } from '../campSite/SearchItems'

export const Prefectures: SearchItems[] = [
  {
    label: '関東',
    items: [
      { id: 1, displayName: '東京', name: 'tokyo' },
      { id: 2, displayName: '神奈川', name: 'kanagawa' },
      { id: 3, displayName: '埼玉', name: 'saitama' },
      { id: 4, displayName: '茨城', name: 'ibaragi' },
      { id: 5, displayName: '群馬', name: 'gunnma' },
      { id: 6, displayName: '栃木', name: 'tochigi' },
      { id: 7, displayName: '千葉', name: 'chiba' },
    ],
  },
  {
    label: '北陸・甲信越',
    items: [
      { id: 8, displayName: '新潟', name: 'niigata' },
      { id: 9, displayName: '富山', name: 'toyama' },
      { id: 10, displayName: '石川', name: 'ishikawa' },
      { id: 11, displayName: '福井', name: 'fukui' },
      { id: 12, displayName: '山梨', name: 'yamanashi' },
      { id: 13, displayName: '長野', name: 'nagano' },
    ],
  },
]
